# MainenanceMonitor Gruppe A2

# Gruppenmitglieder
Danijel Beric
Melchior Lebesmühlbacher
Daniel Stangl
Rhoideridge Heinz

# Beschreibung des Programms
Der Maintenance Monitor ist eine einfache Browser App zum Aufrufen eines einfachen Eingabe-Ausgabe-Programms für Text. Es basiert auf dem Spring-Boot Framework welches den Tomcat Server mit dem Port 8080 nutzt.
Ziel dieses Programmes ist eine Simulation eines Energieanbieters um seine Endverbraucher über etwaige Wartungsarbeiten zu informieren.
## Wie wird der Maintenance Monitor gestartet?
Der Maintenance Monitor wird über die Klasse MaintenancemonitorApplication gestartet. Sobald diese gestartet wurde können die Funktionen des Programms in einem Browser aufgerufen werden.
Zu Testzwecken wird das Programm per Loopback-Adresse aufgerufen. In der URL-Leiste des Browsers wird hierfür folgendes eingefügt:

localhost:8080
## Funktionen von Maintenance Monitor
Die Funktionen zur Eingabe und Ausgabe des Textes erfolgt über Tags in der Url. Diese rufen Methoden des Controllers (MaintenancemonitorContoller) auf. Folgende Tags werden dabei verwendet:

1. localhost:8080/api/message

2. localhost:8080/api/message/set

3. localhost:8080/api/message/reset

### Abrufen der Nachricht
Diese Funktion richtet sich an die Endverbraucher des Energieanbieters. Die Nachricht wird über den Tag

* localhost:8080/api/message

abgerufen. Wurde keine andere Nachricht vom Energieanbieter gesetzt, wird die Default-Nachricht "Everything works as expected" angezeigt.
### Eingabe einer Nachricht
Diese Funktion ist für den Energieanbieter vorgesehen. Die Funktion für die Eingabe wird über den Tag

* localhost:8080/api/message/set

aufgerufen. Die Nachricht wird als **Query-Parameter** direkt in der URL als Key-Value-Paar übergeben. Soll beispielsweise die Nachricht "Wartungsarbeiten bis 12 Uhr" eingegeben werden, wird folgende URL genutzt:

localhost:8080/api/message/set?m=Wartungsarbeiten bis 12 Uhr

Der Key ist in diesem Programm die Variable "m" und der Value jeder beliebige Text nach dem "=".

### Rücksetzen der Nachricht
Um die Nachricht wieder auf seinen Default-Wert "Everything works as expected" zurück zu setzen wird der Tag

* localhost:8080/api/message/reset

aufgerufen.

# Beschreibung der Software-Architektur
Für dieses Programm wurde das MVC-Muster (Model-View-Controller) verwendet.
## Model
Das Model beinhaltet die Daten der Software und vewendet die Klassen _Maintenancemonitor_ und _MaintenancemonitorService_
### Maintenancemonitor
Die Klasse Maintenancemonitor wird verwendet um den Zustand (Status) des Programms abzufragen. Sie beinhaltet außerdem einen Zeitstempel für den Status sowie einen Fehlerstatus um anzuzeigen ob die Default-Nachricht gesetzt ist.
### MaintenancemonitorService
Die Klasse MaintenancemonitorService beinhaltet die Default-Nachricht und generiert den Zeitstempel.
## View
Die Ansicht (View) ist der sichtbare Teil der Software. Sie beinhaltet das HTML-File _index.html_
## Controller
Der Controller stellt die Schnittstelle zwischen der Software am Server und dem Browser dar. Sie wird verwendet um Funktionen der Software aufzurufen. In ihr ist die klasse _MaintenancemonitorController_ enthalten.
### MaintenancemonitorController
In der Klasse MaintenancemonitorController werden die Objekte aus den Model erzeugt. Diese Klasse beinhaltet die Funktionen zum Abrufen und Setzen der Nachrichten.
