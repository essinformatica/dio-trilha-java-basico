
public class UsoIphone {

    public static void main(String[] args) throws Exception {
        Iphone meuIphone = new Iphone();

        // Utilizando o ReprodutorMusical
        meuIphone.selecionarMusica("Bohemian Rhapsody");
        meuIphone.tocar(meuIphone.musicaAtual);
        meuIphone.pausar();

        System.out.println();

        // Utilizando o AparelhoTelefonico
        meuIphone.ligar("11999999999");
        meuIphone.atender();
        meuIphone.iniciarCorreioDeVoz();

        System.out.println();

        // Utilizando o Navegador
        meuIphone.exibirPagina("https://www.google.com");
        meuIphone.adicionarNovaAba();
        meuIphone.atualizarPagina();
    }
}
