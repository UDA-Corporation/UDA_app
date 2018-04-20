#!/bin/bash
echo "
▒█▄░▒█ █▀▀ ▀▀█▀▀ █░░░█ █▀▀█ █▀▀█ █░█ 　 █▀▀ █░░█ █▀▀ █▀▀ █░█ █▀▀ █▀▀█
▒█▒█▒█ █▀▀ ░░█░░ █▄█▄█ █░░█ █▄▄▀ █▀▄ 　 █░░ █▀▀█ █▀▀ █░░ █▀▄ █▀▀ █▄▄▀
▒█░░▀█ ▀▀▀ ░░▀░░ ░▀░▀░ ▀▀▀▀ ▀░▀▀ ▀░▀ 　 ▀▀▀ ▀░░▀ ▀▀▀ ▀▀▀ ▀░▀ ▀▀▀ ▀░▀▀ v0.3 alpha

By UDA Corp. under MIT license
"
#Indicamos cual sera el fichero log y le añadimos cabecera
LOG="ConnectionResults.log"
echo "
▒█▄░▒█ █▀▀ ▀▀█▀▀ █░░░█ █▀▀█ █▀▀█ █░█ 　 █▀▀ █░░█ █▀▀ █▀▀ █░█ █▀▀ █▀▀█
▒█▒█▒█ █▀▀ ░░█░░ █▄█▄█ █░░█ █▄▄▀ █▀▄ 　 █░░ █▀▀█ █▀▀ █░░ █▀▄ █▀▀ █▄▄▀
▒█░░▀█ ▀▀▀ ░░▀░░ ░▀░▀░ ▀▀▀▀ ▀░▀▀ ▀░▀ 　 ▀▀▀ ▀░░▀ ▀▀▀ ▀▀▀ ▀░▀ ▀▀▀ ▀░▀▀ v0.2 alpha

Result(s) of the test(s)

IMPORTANT: If you are seeing this because it popped up, check the last line of this file to see the errors
" >> $LOG
watch -n 30 ./Script.sh

        #Preguntamos al usuario si desea realizar mas tests
        #read -p "Test realizado, ¿desea realizar la comprobacion a otro nodo? (S/N): " RESPUESTA
####done
#Indicamos al usuario que los resultados ya estan disponibles y se los mostramos
#echo ""
#echo "Los resultados estan guardados en el fichero "ConnectionResults.log""
#sleep 1;
#echo "Mostrando resultados..."
#Dejamos 2 segundos para que vea el mensaje antes de utilizar el terminal de nuevo
#sleep 2;
#cat ConnectionResults.log

##Estructura de error (no conexion)
##Node: nodo - 2018-04-19 11:02:34 - Failed - Check status of the node nodo!

##Estructura de conexion satisfactoria
##Node: nodo - 2018-04-19 11:02:34 - Successful
