#!/bin/bash
echo "
▒█▄░▒█ █▀▀ ▀▀█▀▀ █░░░█ █▀▀█ █▀▀█ █░█ 　 █▀▀ █░░█ █▀▀ █▀▀ █░█ █▀▀ █▀▀█
▒█▒█▒█ █▀▀ ░░█░░ █▄█▄█ █░░█ █▄▄▀ █▀▄ 　 █░░ █▀▀█ █▀▀ █░░ █▀▄ █▀▀ █▄▄▀
▒█░░▀█ ▀▀▀ ░░▀░░ ░▀░▀░ ▀▀▀▀ ▀░▀▀ ▀░▀ 　 ▀▀▀ ▀░░▀ ▀▀▀ ▀▀▀ ▀░▀ ▀▀▀ ▀░▀▀ v1.0

By UDA Corp. under MIT license
"
rm ConnectionResults.log
#Indicamos cual sera el fichero log y le añadimos cabecera
LOG="ConnectionResults.log"
echo "
Result(s) of the test(s)

IMPORTANT: If you are seeing this because it popped up, check the last line of this file to see the errors
" >> $LOG
watch -n 30 ./Script.sh

##Estructura de error (no conexion)
##Node: nodo - 2018-04-19 11:02:34 - Failed - Check status of the node nodo!

##Estructura de conexion satisfactoria
##Node: nodo - 2018-04-19 11:02:34 - Successful
