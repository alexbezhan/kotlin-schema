package experiments

import java.io.File
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic.Kind.ERROR

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("org.kotlin.annotationProcessor.TestAnnotation")
@SupportedOptions(AnnotationProcesssor.KAPT_KOTLIN_GENERATED_OPTION_NAME)
class AnnotationProcesssor : AbstractProcessor() {
    companion object {
        const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "kapt.kotlin.generated"
    }
    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        val annotatedElements = roundEnv.getElementsAnnotatedWith(Shape::class.java)
        if (annotatedElements.isEmpty()) return false

        val kaptKotlinGeneratedDir = processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME] ?: run {
            processingEnv.messager.printMessage(ERROR, "Can't find the target directory for generated Kotlin files.")
            return false
        }

        val generatedCode: String = ""

        File(kaptKotlinGeneratedDir, "testGenerated.kt").apply {
            parentFile.mkdirs()
            writeText(generatedCode)
        }

        return true
    }

    fun Element.toTypeElementOrNull(): TypeElement? {
        if (this !is TypeElement) {
            processingEnv.messager.printMessage(ERROR, "Invalid element type, class expected", this)
            return null
        }

        return this
    }
}