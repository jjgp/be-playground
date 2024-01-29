import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  alias(libs.plugins.kotlin.jvm) apply false
}

allprojects {
  group = "com.beplayground"
  version = property("VERSION_NAME") as String

  repositories {
    mavenCentral()
  }
}

subprojects {
  tasks.withType<KotlinCompile> {
    compilerOptions {
      jvmTarget.set(JvmTarget.JVM_19)
      freeCompilerArgs.add("-Xjvm-default=all")
    }
  }

  tasks.withType<JavaCompile> {
    options.release.set(19)
  }
}

