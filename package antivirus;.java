package antivirus;

import java.io.File;
import java.util.Scanner;

public class Antivirus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o caminho do diretório para a busca: ");
        String caminhoDiretorio = scanner.nextLine();

        File diretorio = new File(caminhoDiretorio);
        if (diretorio.exists() && diretorio.isDirectory()) {
            File[] listaArquivos = diretorio.listFiles();

            if (listaArquivos != null && listaArquivos.length > 0) {
                for (File arquivo : listaArquivos) {
                    if (arquivo.isFile() && (arquivo.getName().toLowerCase().endsWith(".exe") || arquivo.getName().toLowerCase().endsWith(".bat"))) {
                        System.out.println("Arquivo suspeito encontrado: " + arquivo.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("O diretório está vazio ou não contém arquivos relevantes.");
            }
        } else {
            System.out.println("O caminho fornecido não é um diretório válido.");
        }
        
        scanner.close();
    }
}