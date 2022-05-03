# Käyttöohje


## Ohjelman käynnistys

suorita komentoriviltä projektin juuresta komennolla:

`mvn compile exec:java -Dexec.mainClass=com.mvaana.memorygame.ui.App`

## Pelin aloitus

Sovellus avautuu pelin menuun, josta voi valita neljästä eri vaikeustasosta mieluisimman.

![](kuvat/menuView.PNG)

## Pelaaminen

Vaikeustason valinnan jälkeen avautuu pelinäkymä, jossa nappeja painamalla käännetään kortteja.

![](kuvat/gameView.PNG)
![](kuvat/gameState.PNG)

## Pelin lopetus

Kaikkien parien löydyttyä pelin voi pelata samalla vaikeustasolla uudestaan tai palata menunäkymään valitsemaan uusi vaikeustaso. Sovellus suljetaan raksista oikeasta yläkulmasta.

![](kuvat/gameWin.PNG)

