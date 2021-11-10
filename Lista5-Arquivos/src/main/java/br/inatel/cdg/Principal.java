package br.inatel.cdg;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Path caminho = Paths.get("funcionarios.csv");
        Path filtrados = Paths.get("func_filtrado.csv");
        Set<String> filtroFunc = new LinkedHashSet<>();

        try {
            List<String> linhas = Files.readAllLines(caminho);
            linhas.forEach(linha -> {
                String vetorSplit[] = linha.split(",");
                filtroFunc.add(vetorSplit[0] + ", " + vetorSplit[3] + ",  " + vetorSplit[4]);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder linha = new StringBuilder();
        filtroFunc.forEach(funcionario -> {
            if (!funcionario.contains("0")){
                linha.append(funcionario + "\n");
            }
        });

        try {
            Files.writeString(filtrados, linha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
