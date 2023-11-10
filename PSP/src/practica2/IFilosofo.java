package practica2;

public interface IFilosofo extends Runnable{

    /** Estado en el que se encuentra el Filósofo */
    public enum Estado {
        PENSANDO,
        HAMBRIENTO,
        COMIENDO,
        SACIADO,
        RETIRADO
      }

    /** Tiene que saber contestar a cuál es su nombre */
    public String getNombre();

    /** Tiene que saber contestar al número de bocados que ha comido */
    public Long getNumeroBocados();

    /** Tiene que saber contestar cómo se encuentra */
    public IFilosofo.Estado getEstado();

    /** Tiene que saber contestar si es hablador o no (Será hablador si alguna vez escribe algo por salida estándar (System.out) */
    public boolean isHablador();

    /** Establece que debe quedarse callado y no escribir nada por salida estándar (System.out) */
    public void setHablador(boolean hablador);

    /** Tiene que saber contestar cuanto es el tiempo máximo que puede quedar pensando */
    public Long getMillisMaxPensando();

    /** Establece el tiempo máximo que puede estar pensando */
    public void setMillisMaxPensando(long millisMaxPensando);

    /** Tiene que saber contestar cuanto es el tiempo máximo que va a tardar entre bocado y bocado mientras está comiendo */
    public Long getMillisMaxEntreBocadoAndBocado();

    /** Establece el tiempo máximo que puede estar esperando entre bocado y bocado mientras está comiendo */
    public void setMillisMaxEntreBocadoAndBocado(long millisMaxEntreBocadoAndBocado);

    /** Comienza a interactuar en la mesa */
    public void comienza();

    /** Se levantará de la mesa y se irá antes de volver a pensar*/
    public void retirate();

    /** Interrumpirá lo que estea haciendo en la mesa */
    public void interrumpete();
}
