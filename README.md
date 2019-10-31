# JSON Views Test

This is a sample application to show how JSON views work.  Inspired by
[this video](https://youtu.be/ROwKJZJSTQc).

## To Run

    $ ./gradlew bootRun

You can get a list of artists with:

    $ http :8080/artists

You can get a specific artist with:

    $ http :8080/artists/1

You can create a new artist with:

    $ http POST :8080/artists "name=Billie Eilish"
