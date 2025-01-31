# ReceptSpringRestAPI
Den här är ett API som kan lägga till data, hämta, ta bort och spara ett recept i json fil. Finns en model med attribute id, name, imageUrl och instructions. Frontenden utvecklats seperat.

## Byggts med
  * Spring boot
  * Maven
  * Java
  * Tillagda dependencies:
      * Spring Web
      * Dev Tools
      * Jackson-core

## Installation guide
* Klona ner repo.
* Öppna den med t.ex. VSC
* Köra progrmmet (ReceptSpringRestApplication)

## Testa
I Postman:

  ### Lägga till ett recept:
    * Använd POST metod och länk: localhost:8080/api/favorites för att lägga till ett recept.
    * Under body, välj 'raw' och 'json'. Skiv data som ska lägga till. Data ska sparas i json fil.
    * Exempel data:
              {
                "id": 1,
                "name": "Spaghetti Bolognese",
                "imageUrl": "https://www.example.com/spaghetti-bolognese.jpg",
                "instructions": "Boil spaghetti, cook meat, mix with sauce."
              }

  ### Visa tillagda data:
    * Använd GET metod med länk: localhost:8080/api/favorites
  
  ### Ta bort ett recept:       
    * Använd DELETE metod med länk: localhost:8080/api/favorites/{id} t.ex localhost:8080/api/favorites/1
