/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * @author Felipe
 */
public class UtilGerador {

    public static String gerarCaracter(int qtdLetra) {
        String palavra = "";
        int indice;
        String[] minusculas = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        
        for (int i = 0; i < qtdLetra; i++) {
            indice = (int) (Math.random() * minusculas.length);
            palavra += minusculas[indice];
        }
        return palavra;
    }

    public static String gerarNome() {
        String nome;
        int indice;
        String[] nomes = {"João", "Maria", "Beatriz", "Antonio", "Jefferson", ""
            + "Silvio", "Tatiana", "Sueli", "Joana", "Camilla", "Kelly",
            "Felipe", "Vinicius", "Marcos", "Pedro", "Marcelo", "Henrique"};
        indice = (int) (Math.random() * nomes.length);
        nome = nomes[indice] + " " + gerarSobreNome();
        return nome;
    }

    private static String gerarSobreNome() {
        String sobrenome;
        int indice;
        String[] nomes = {"Silva", "Motto", "Ribeiro", "Souza", "Araujo", "May",
            "junior", "Cionette", "Aurelio", "Pereira", "Oliveira", "Matos",
            "Barbosa", "Nascimento"};
        indice = (int) (Math.random() * nomes.length);
        sobrenome = nomes[indice];
        return sobrenome;
    }

    public static String gerarCidade() {
        String cidade;
        int indice;
        String[] cidades = {"Florianópolis", "São José", "Palhoça", "São Bento",
            "Biguaçu", "Curitiba", "Urupema", "Tijucas", "Balneário", "Santo Antonio"};
        indice = (int) (Math.random() * cidades.length);
        cidade = cidades[indice];
        return cidade;
    }

    public static String gerarNumero(int qtd) {
        String numero = "";
        for (int i = 0; i < qtd; i++) {
            numero += (int) (Math.random() * 10);
        }
        return numero;
    }

    public static String gerarEmail() {
        return gerarCaracter(8) + "@email.com";
    }

    public static String gerarTelefoneFixo() {
        // (48)3541-1132
        return "(48)3" + gerarNumero(3) + "-" + gerarNumero(4);
    }

    public static int criarNumeroEntre2Valores(int menor, int maior) {
        int numero = (int) (Math.random() * (maior - menor));

        if (numero == 0) {
            numero++;
        }
        numero = numero + menor;

        return numero;
    }
}