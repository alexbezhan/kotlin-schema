package app.generated

interface ProductCreationShape {
    val name: String
    val description: String
}
interface MaybeExistingProductShape: ProductCreationShape {
    val id: Long?
    override val name: String
    override val description: String
    val vendors: List<Vendor>
}
interface LightProductShape {
    val id: Long
    val name: String
}
interface ProductShape: MaybeExistingProductShape, ProductCreationShape, LightProductShape {
    override val id: Long
    override val name: String
    override val description: String
    override val vendors: List<Vendor>
}

data class ProductCreationFields(override val name: String, override val description: String) : ProductCreationShape
data class MaybeExistingProduct(override val id: Long?, override val name: String, override val description: String, override val vendors: List<Vendor>):
    MaybeExistingProductShape
data class LightProduct(override val id: Long, override val name: String) : LightProductShape
data class Product(override val id: Long, override val name: String, override val description: String,
                   override val vendors: List<Vendor>) : ProductShape


interface VendorCreationShape {
    val productId: Long
    val name: String
}
interface VendorShape: VendorCreationShape {
    val id: Long
    override val productId: Long
    override val name: String
}
interface LightVendorShape {
    val name: String
}
data class VendorCreationFields(override val productId: Long, override val name: String): VendorCreationShape
data class Vendor(override val id: Long, override val productId: Long, override val name: String) : VendorShape
data class LightVendor(override val name: String): LightVendorShape