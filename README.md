# Muistipeli

### Ohjelmistotekniikan harjoitustyö

Sovellus on yksinkertainen muistipeli neljällä eri vaikeustasolla. Vaikeustasosta riippuen on tarkoitus kääntää kerrallaan kaksi korttia ja muodostaa näin niistä pareja. Pelin voittaa kun kaikki parit on löydetty.

## Dokumentaatio

[Käyttöohje](https://github.com/karppienkingi/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Määrittelydokumentti](https://github.com/karppienkingi/ot-harjoitustyo/blob/master/dokumentaatio/Maarittelydokumentti.md)

[Arkkitehtuurikuvaus](https://github.com/karppienkingi/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/karppienkingi/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)

[Työaikakirjanpito](https://github.com/karppienkingi/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Changelog](https://github.com/karppienkingi/ot-harjoitustyo/blob/master/dokumentaatio/changelog.md)

## Releaset

[viikko 7](https://github.com/karppienkingi/ot-harjoitustyo/releases/tag/viikko7)

[viikko 6](https://github.com/karppienkingi/ot-harjoitustyo/releases/tag/viikko6)

[viikko 5](https://github.com/karppienkingi/ot-harjoitustyo/releases/tag/viikko5)

## Komentorivitoiminnot

### Jarin generointi ja ajaminen

`mvn package`

generoi target-kansioon jar-tiedoston nimeltä *memorygame-1.0-shaded.jar*.
Tällä komennolla generoituu myös tiedosto *memorygame-1.0.jar*, mutta tätä ei voi käyttää.

Jar tiedoston voi suorittaa komennolla 

`java -jar memorygame-1.0-shaded.jar`

### Ohjelman suoritus
Suorita ohjelma komentoriviltä komennolla: 

`mvn compile exec:java -Dexec.mainClass=com.mvaana.memorygame.Main`

### Testaus
Ohjelman testaus suoritetaan komennolla:

`mvn test`

### Testikattavuus
Testikattavuuden saat luotua komennolla:

`mvn test jacoco:report`

### Checkstyle

`mvn jxr:jxr checkstyle:checkstyle`

### JavaDoc

`mvn javadoc:javadoc`
