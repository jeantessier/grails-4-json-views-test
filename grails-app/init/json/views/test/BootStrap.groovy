package json.views.test

class BootStrap {

    static final artists = [
        "P!nk": [
            "You Can't Take Me Home",
            "Funhouse",
            "Beautiful Trauma",
        ],
        "Prince": [
            "Purple Rain",
        ],
        "Avril Lavigne": [],
    ]

    def init = { servletContext ->
        Artist.withTransaction {
            artists.each { name, albums ->
                if (!Artist.findByName(name)) {
                    def artist = new Artist(name: name)
                    albums.each { artist.addToAlbums(title: it) }
                    artist.save()
                }
            }
        }
    }

}
