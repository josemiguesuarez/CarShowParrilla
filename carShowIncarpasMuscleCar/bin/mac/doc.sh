#!/bin/sh

# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogotá - Colombia)
# Departamento de Ingeniería de Sistemas y Computación
# Licenciado bajo el esquema Academic Free License version 2.1
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: carShowIncarpasMuscleCar
# Autor: Jose Miguel Suarez - 20-ene-2014
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

#SET CLASSPATH=
# ---------------------------------------------------------
# Asegura la creación del directorio docs/api
# ---------------------------------------------------------

cd ../../docs
mkdir api
cd ../bin/mac

# ---------------------------------------------------------
# Genera la documentación
# ---------------------------------------------------------

javadoc -sourcepath ../source -d ../docs/api -subpackages uniandes.cupi2.carShowIncarpasMuscleCar

stty echo