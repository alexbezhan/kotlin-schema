package app

import app.generated.LightProduct
import app.generated.LightProductShape
import app.generated.Product
import app.generated.ProductCreationFields
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Column
import processor.Shapes

object ProductTable : IdTable<Long>("products") {
    override val id: Column<EntityID<Long>> = long("id").autoIncrement().entityId()
    override val primaryKey by lazy { super.primaryKey ?: PrimaryKey(id) }

    @Shapes(["ProductCreationShape"])
    val name = varchar("name", 255)

    @Shapes(["ProductCreationShape"])
    val description = varchar("description", 255)
}

object VendorTable : LongIdTable("vendors") {
    val productId = long("product_id").references(ProductTable.id)
    val name = varchar("name", 255)
}

fun calculateLightStuff(product: LightProductShape): Long = product.id + product.name.length

fun calculateHeavyStuff(product: Product): Long = calculateLightStuff(product) + product.vendors.size

fun main() {
    val productId = createProduct(ProductCreationFields("Product", "description"))
    val product: Product = getProduct(productId)!!
    calculateHeavyStuff(product)
    calculateLightStuff(product)

    val lightProduct: LightProduct = getLightProduct(productId)!!

    calculateLightStuff(lightProduct)
}