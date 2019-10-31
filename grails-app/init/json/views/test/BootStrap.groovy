package json.views.test

class BootStrap {

    def init = { servletContext ->
        new Artist(name: "P!nk")
            .addToAlbums(title: "You Can't Take Me Home")
            .addToAlbums(title: "Funhouse")
            .addToAlbums(title: "Beautiful Trauma")
            .save()

        new Artist(name: "Prince")
            .addToAlbums(title: "Purple Rain")
            .save()

        new Artist(name: "Avril Lavigne")
            .save()
    }

}
