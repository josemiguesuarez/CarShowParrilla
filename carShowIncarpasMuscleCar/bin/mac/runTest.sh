#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n1_prueba
# Autor: Luis - 25-Mar-2010
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo
#SET CLASSPATH=

# ---------------------------------------------------------
# Ejecucion de las pruebas
# ---------------------------------------------------------

cd ../..
java -ea -classpath lib/carShowIncarpasMuscleCar.jar:test/lib/carShowIncarpasMuscleCarTest.jar:test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.carShowIncarpasMuscleCar.test.MuscleCarTest

cd bin/mac

stty echo