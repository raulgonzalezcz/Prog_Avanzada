package mx.unam.programacionavanzada.excepciones;

/**
 * Ejemplo de uso de excepciones
 * @author Gabriel Gonz&aacute;lez
 * @author Raúl González Cruz
 * @since 16/09/18
 *
 */
public class PruebaExcepcion {
	/**
	 * Funci&oacute;n que lanza la excepci&oacute;n personalizada <code>MiExcepcion</code>
	 * @throws MiExcepcion Excepci&oacute;n personalizada
	 */
	public void provocarMiExcepcion() throws MiExcepcion{
		throw new MiExcepcion(123, "Error asociado con el código 123");
	}
	
	/**
	 * &iquest;Por qu&eacute; a pesar de emplear <code>throw new RuntimeException</code> dentro del 
	 * cuerpo de la funci&oacute;n, su declaraci&oacute;n no requiere especificar 
	 * <code>throws RuntimeException</code>?<br>
	 * 
	 * <br>RuntimeException es la superclase de esas excepciones que se pueden lanzar durante 
	 * el funcionamiento normal de la Máquina Virtual de Java; por lo que RuntimeException 
	 * y sus subclases son consideradas excepciones no verificadas (unchecked exceptions). 
	 * Estas excepciones no necesitan ser declaradas en un método o cláusula throws del 
	 * constructor si pueden ser lanzadas por la ejecución del método o el constructor 
	 * y propagarse fuera del método o del límite del constructor.<br> 
	 * 
	 * <br>Las excepciones no verificadas deben reservarse para los errores del sistema que 
	 * representan alguna condición de falla no controlada (como NullPointer, OutOfMemory, entre otras), 
	 * provocando que la aplicación deba finalizar con esa excepción. Se espera que 
	 * ocurran excepciones de este tipo en cualquier 
	 * parte del programa, las cuales indican errores no predecibles en la lógica del código
	 * que normalmente no deberían ocurrir. Por ello se utilizan para comprobar la consistencia 
	 * interna del programa y solo deberían recuperarse si realmente sabemos cuáles 
	 * son las implicaciones de esa recuperación. 
	 * 
	 * También necesitamos usar RuntimeException en caso de que tengamos un bloque 
	 * estático en el que se esté creando instancias y se desee lanzar una 
	 * excepción si falla la creación de instancias. Como los bloques estáticos 
	 * no tienen la palabra clave throw / throws, RuntimeExceptions se vuelve adecuado
	 * en este caso.<br> 
	 * 
	 * <br>Finalmente se resume que RuntimeException, al ser una unchecked exception, establece que:<br>
	 * 
	 * <br>
	 * <ul>
	 * <li> La declaración del método no tiene que indicar que se puede lanzar una RuntimeException con la palabra reservada throws</li>
	 * <li> Otras partes del programa que llaman ese método no están obligadas a detectar la excepción ni a reconocerla de alguna manera</li>
	 * <li> Aunque no hace falta la cláusula throws en la declaración del método, si 
	 * no son capturadas estas excepciones, pasarán al método de nivel 
	 * superior y seguirán así hasta llegar a la función principal, 
	 * momento en el que provocará la salida de nuestro programa mostrando el error 
	 * correspondiente dado que no se capturó la excepción </li>
	 * </ul>
	 * <br>
	 * 
	 * <br>Dado que RuntimeException extiende de la clase Exception, en este caso 
	 * throw new RuntimeException(msg) está creando una instancia de RuntimeException
	 * con el mensaje especificado antes de ser lanzada.<br>
	 * 
	 * <br>
	 * <ol> Referencias: 
	 * <li><a>https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/RuntimeException.html </a></li>
	 * <li><a>http://www.jtech.ua.es/j2ee/publico/lja-2012-13/sesion03-apuntes.html</a></li>
	 * </ol>
	 * <br>
	 */
	public void lanzarExcepcionEnTiempoEjecucion(){
		throw new RuntimeException("Error en tiempo de ejecución");
	}
	
	/**
	 * &iquest;Por qu&eacute; no se declara una excepci&oacute;n?<br>
	 * 
	 * <br>En este caso, para Java la definición del método y su contenido no tiene en primera instancia 
	 * errores en la sintaxis (conocidos también como errores en tiempo de compilación,
	 * son causados cuando el compilador no puede reconocer una sentencia; 
	 * por lo que se devuelve un mensaje de error, usualmente con una línea de 
	 * código de referencia). Sin embargo, por la experiencia sabemos que el programa lanzará un error 
	 * en la lógica (son conocidos como bugs y hacen referencia a errores que normalmente nos toman tiempo 
	 * hasta encontrarlos. Otros ejemplos son cuando una clase no está en el directorio correcto, 
	 * olvidar que los índices en Java empiezan en 0, entre otros).<br>
	 * 
	 * <br>Por ello, a pesar de que no existe error en tiempo de compilación, se marcará
	 * error en tiempo de ejecución dada la división entre 0. Entonces creo
	 * que el autor del código se percató que la división entre 0 se refiere a un tipo
	 * de excepción verificada (ArithmeticException), la cual puede ser atrapada en
	 * un bloque try-catch cuando se invoque la ejecución del método dentro del programa con el fin
	 * de manejar adecuadamene esta sentencia susceptible de lanzar una excepción, evitando
	 * que el programa termine su ejecución repentinamente por este bug.<br>
	 * 
	 * <br>Por lo cual, considero que el autor decidió únicamente establecer, a manera de ejemplo,
	 * la lógica que 
	 * causa un error lógico en tiempo de ejecución dentro del método, moviendo la carga
	 * de trabajo para atrapar la excepción en la parte del código donde se llamará 
	 * este método (en la función principal main) dentro de un bloque try-catch y permitir que 
	 * la ejecución del código continúe, reconociendo oportunamente la existencia de esta excepción que puede causar
	 * el colpaso inmediato de nuestro programa.<br>
	 * 
	 * <br>
	 * <ol> Referencias: 
	 * <li><a>http://www.ciberaula.com/articulo/errores_comunes_programacion_java/ </a></li>
	 * <li><a>http://www.jtech.ua.es/j2ee/publico/lja-2012-13/sesion03-apuntes.html</a></li>
	 * </ol>
	 * <br>
	 
	 */
	public void provocarExcepcionEnTiempoEjecucion(){
		System.out.println(33/0);
	}
	
	public static void main(String []args) {
		System.out.println("Iniciando aplicación");
		
		PruebaExcepcion prueba = new PruebaExcepcion();
		
		try {
			System.out.println("Llamando la función provocarMiExcepcion()");
			prueba.provocarMiExcepcion();
			
			System.out.println("Llamando la función lanzarExcepcionEnTiempoEjecucion()");
			prueba.lanzarExcepcionEnTiempoEjecucion();
			
			System.out.println("Llamando la función provocarExcepcionEnTiempoEjecucion()");
			prueba.provocarExcepcionEnTiempoEjecucion();
		} catch (MiExcepcion e) {
			e.printStackTrace();
			System.err.println("Código de error: " + e.getCodigo());
			System.err.println("Mensaje de error: " + e.getMessage());
		} catch(ArithmeticException ae) {
			ae.printStackTrace();
			System.err.println("Mensaje de error: " + ae.getMessage());
		} catch(RuntimeException re) {
			re.printStackTrace();
			System.err.println("Mensaje de error: " + re.getMessage());
		}
		
		// Continua programa porque prueba.provocarMiExcepcion() condujo al bloque catch
		System.out.println("Continuando ejecución del programa");
		try {
		System.out.println("Llamando la funci&oacute;n lanzarExcepcionEnTiempoEjecucion() fuera del bloque try-catch");
		prueba.lanzarExcepcionEnTiempoEjecucion();
		}catch(RuntimeException re) {
			System.err.println("Atrapando excepción para continuar la ejecución del programa.");
			re.printStackTrace();
			System.err.println("Mensaje de error: " + re.getMessage());
		}
		
		System.out.println("Continuando ejecución del programa");
		try {
		System.out.println("Llamando la funci&oacute;n provocarExcepcionEnTiempoEjecucion() fuera del bloque try-catch");
		prueba.provocarExcepcionEnTiempoEjecucion();
		}catch(ArithmeticException ae) {
			System.err.println("Atrapando excepción para continuar la ejecución del programa.");
			ae.printStackTrace();
			System.err.println("Mensaje de error: " + ae.getMessage());
		}
		
		System.out.println("Fin del programa");
		
	}
}
