package experiments.generated

import experiments.ProductTable
import experiments.VendorTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

fun <T> UpdateBuilder<T>.set(fields: ProductCreationShape) {
    this[ProductTable.name] = fields.name
    this[ProductTable.description] = fields.description
}

fun ResultRow.toProduct(vendors: List<Vendor>) = Product(
    this[ProductTable.id].value,
    this[ProductTable.name],
    this[ProductTable.description],
    vendors,
)

fun ResultRow.toLightProduct() = LightProduct(
    this[ProductTable.id].value,
    this[ProductTable.name],
)

fun ResultRow.toVendor() =
    Vendor(
        this[VendorTable.id].value,
        this[VendorTable.productId],
        this[VendorTable.name],
    )

fun <T> UpdateBuilder<T>.set(vendor: VendorCreationShape) {
    this[VendorTable.productId] = vendor.productId
    this[VendorTable.name] = vendor.name
}