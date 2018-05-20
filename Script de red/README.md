Estructura del fichero de log
====
Nuestro planteamiento es ejecutar un ping a cada nodo de la red y al de google, con un script bash, (todos los contenedores que hay en proxmox y 8.8.8.8), enviando 4 paquetes, y, que se ejecute cada 10 minutos automáticamente desde que se enciende el contenedor y se inicia sesión.  
En cuanto haya un error de conexión en uno de los nodos, se creará inmediatamente en la terminal un mensaje que indique el nodo que da problemas. Si en la próxima prueba (cada 10 minutos) hay conexion a internet, se eliminará el fichero log. Se crea y se mantiene solo mientras hay problemas en 1 o más nodos.  
La estructura del fichero “log” será así:  
<br/>
>#Estructura de error (no respuesta) dentro del LOG   
>Nodo: $node - 2018-04-19 11:02:34 - Failed - Check status of the node $node!  
