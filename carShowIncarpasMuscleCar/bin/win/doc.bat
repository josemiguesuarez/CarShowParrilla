@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: carShowIncarpasMuscleCar
REM Autor: Jose Miguel Suarez - 20-ene-2014
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Asegura la creaci�n del directorio docs/api
REM ---------------------------------------------------------

cd ../../docs
mkdir api
cd ../../bin/win

REM ---------------------------------------------------------
REM Genera la documentaci�n
REM ---------------------------------------------------------

javadoc -sourcepath ../source -d ../docs/api -subpackages uniandes.cupi2.carShowIncarpasMuscleCar