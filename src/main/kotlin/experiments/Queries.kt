package experiments

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.batchInsert
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

val database: Database = TODO("")

fun createProduct(product: ProductCreationFields): Long = transaction(database) {
    ProductTable.insertAndGetId {
        it.set(product)
    }.value
}

fun getProduct(id: Long): Product? = transaction(database) {
    ProductTable.select { ProductTable.id eq id }.firstOrNull()?.toProduct(getVendors(id))
}

fun getLightProduct(id: Long): LightProduct? = transaction(database) {
    ProductTable.select { ProductTable.id eq id }.firstOrNull()?.toLightProduct()
}

fun getVendors(productId: Long) = transaction(database) {
    VendorTable.select { VendorTable.productId eq productId }.map {
        it.toVendor()
    }
}

fun addVendors(vendors: List<VendorCreationFields>) = transaction(database) {
    VendorTable.batchInsert(vendors) {
        set(it)
    }
}