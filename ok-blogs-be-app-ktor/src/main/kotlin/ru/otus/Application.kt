package ru.otus

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import ru.otus.config.articleRoute
import ru.otus.config.categoryRoute
import ru.otus.config.jsonConfig
import ru.otus.config.tagRoute

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

/**
 * Please note that you can use any other name instead of *module*.
 * Also note that you can have more then one modules in your application.
 * */
@Suppress("unused") // Referenced in application.conf
@JvmOverloads
fun Application.module(testing: Boolean = false) {
	install(CORS) {
	    method(HttpMethod.Options)
	    method(HttpMethod.Put)
	    method(HttpMethod.Delete)
	    method(HttpMethod.Patch)
	    header(HttpHeaders.Authorization)
	    header("MyCustomHeader")
	    allowCredentials = true
	    anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
	}
	
	install(ContentNegotiation) {
	    json(
			contentType = ContentType.Application.Json,
			json = jsonConfig
	    )
	}
	
	
	routing {
	    get("/") {
	        call.respondText("Hello World!")
	    }
	}

	routing {
	    // Static feature. Try to access `/static/ktor_logo.svg`
	    static("/static") {
	        resources("static")
	    }

		articleRoute()
		categoryRoute()
		tagRoute()
	}


}

