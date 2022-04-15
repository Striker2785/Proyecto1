import javax.swing.ImageIcon;

public class Images {
    ListaImagenes imagenes;
    ImageIcon oso = new ImageIcon("C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Oso.jpeg");
    ImageIcon burro = new ImageIcon("C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Burro.jpeg");
    ImageIcon foca = new ImageIcon("C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Foca.jpeg");
    ImageIcon gato = new ImageIcon("C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Gato.jpeg");
    ImageIcon leon = new ImageIcon("C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Leon.jpeg");
    ImageIcon pato = new ImageIcon("C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Pato.jpeg");
    ImageIcon perico = new ImageIcon("C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Perico.jpeg");
    ImageIcon rana = new ImageIcon("C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Rana.jpeg");

    
    public Images(){
        imagenes = new ListaImagenes();
        imagenes.addPrimero(oso);
        imagenes.addPrimero(oso);
        imagenes.addPrimero(burro);
        imagenes.addPrimero(burro);
        imagenes.addPrimero(foca);
        imagenes.addPrimero(foca);
        imagenes.addPrimero(gato);
        imagenes.addPrimero(gato);
        imagenes.addPrimero(leon);
        imagenes.addPrimero(leon);
        imagenes.addPrimero(pato);
        imagenes.addPrimero(pato);
        imagenes.addPrimero(perico);
        imagenes.addPrimero(perico);
        imagenes.addPrimero(rana);
        imagenes.addPrimero(rana);

    }
    public ListaImagenes getLista(){
        return imagenes;
    }

}

