

public class Images {
    ListaImagenes imagenes;
    String oso = "C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Oso.jpg";
    String burro = "C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Burro.jpg";
    String foca = "C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Foca.jpg";
    String gato = "C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Gato.jpg";
    String leon = "C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Leon.jpg";
    String pato = "C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Pato.jpg";
    String perico = "C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Perico.jpg";
    String rana = "C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Rana.jpg";

    
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

