
public class Iphone implements AparelhoTelefonico, ReprodutorMusical, NavegadorInternet {

    private String numero;
    String musicaAtual;
    private String urlAtual;

    @Override
    public void ligar(String numero) {
        this.numero = numero;
        System.out.println("Ligando para " + numero);
    }

    @Override
    public void atender() {
        System.out.println("Atendendo chamada de " + numero);
    }

    @Override
    public void iniciarCorreioDeVoz() {
        System.out.println("Iniciando correio de voz");
    }

    @Override
    public void tocar(String musica) {
        this.musicaAtual = musica;
        System.out.println("Tocando " + musica);
    }

    @Override
    public void pausar() {
        System.out.println("Pausando " + musicaAtual);
    }

    @Override
    public void selecionarMusica(String musica) {
        this.musicaAtual = musica;
        System.out.println("Selecionando " + musica);
    }

    @Override
    public void exibirPagina(String url) {
        this.urlAtual = url;
        System.out.println("Exibindo página: " + url);
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Atualizando página: " + urlAtual);
    }

}
