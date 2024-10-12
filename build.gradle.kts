plugins {
  id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(platform("org.junit:junit-bom:5.9.1"))
  testImplementation("org.junit.jupiter:junit-jupiter")

  implementation("com.google.auth:google-auth-library-oauth2-http:1.19.0")
}

tasks.test {
  useJUnitPlatform()
}