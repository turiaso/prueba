##Objetivo
En la base de datos de comercio electr�nico de la compa��a disponemos de la tabla PRICES que refleja el precio final (pvp) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. A continuaci�n se muestra un ejemplo de la tabla con los campos relevantes:
 
PRICES
-------
 
BRAND_ID         START_DATE                                    END_DATE                        PRICE_LIST                   PRODUCT_ID  PRIORITY                 PRICE           CURR
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1         2020-06-14-00.00.00                        2020-12-31-23.59.59                        1                        35455                0                        35.50            EUR
1         2020-06-14-15.00.00                        2020-06-14-18.30.00                        2                        35455                1                        25.45            EUR
1         2020-06-15-00.00.00                        2020-06-15-11.00.00                        3                        35455                1                        30.50            EUR
1         2020-06-15-16.00.00                        2020-12-31-23.59.59                        4                        35455                1                        38.95            EUR
 
Campos: 
 
BRAND_ID: foreign key de la cadena del grupo (1 = ZARA).
START_DATE , END_DATE: rango de fechas en el que aplica el precio tarifa indicado.
PRICE_LIST: Identificador de la tarifa de precios aplicable.
PRODUCT_ID: Identificador c�digo de producto.
PRIORITY: Desambiguador de aplicaci�n de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor num�rico).
PRICE: precio final de venta.
CURR: iso de la moneda.
 
Se pide:
 
Construir una aplicaci�n/servicio en SpringBoot que provea una end point rest de consulta  tal que:
 
Acepte como par�metros de entrada: fecha de aplicaci�n, identificador de producto, identificador de cadena.
Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicaci�n y precio final a aplicar.
 
Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el nombre de los campos y a�adir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los mismos).
              
Desarrollar unos test al endpoint rest que  validen las siguientes peticiones al servicio con los datos del ejemplo:
                                                                                       
-          Test 1: petici�n a las 10:00 del d�a 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: petici�n a las 16:00 del d�a 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: petici�n a las 21:00 del d�a 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: petici�n a las 10:00 del d�a 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: petici�n a las 21:00 del d�a 16 del producto 35455   para la brand 1 (ZARA)
 
 
Se valorar�:
 
Dise�o y construcci�n del servicio.
Calidad de C�digo.
Resultados correctos en los test.

##Stack ejecucion
En sistemas unix será necesario ampliar memoria para ejecutar el servidor de sonar:

```
$ sudo sysctl -w vm.max_map_count=262144
$ sudo sysctl -w fs.file-max=65536
```

En sistems Windows: 
```
wsl -d docker-desktop
sysctl -w vm.max_map_count=262144
```

```
./docker compose up -d
```
Conectarse a:
* DocApi:  [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
* Sonar:   [http://localhost:9000](http://localhost:9000)
* Jaeger:  [http://localhost:16686](http://localhost:16686)
* Adminer:   [http://localhost:8000](http://localhost:8000)


##Sonar ejecucion

```
./gradlew clean test sonarqube -Dsonar.host.url=http://localhost:9000 -Dsonar.login=admin -Dsonar.password=admin
.\gradlew.bat clean test sonarqube -Dsonar.host.url=http://localhost:9000 -Dsonar.login=admin -Dsonar.password=1234
```
