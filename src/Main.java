import classes.Passageiro;
import classes.Tripulacao;
import classes.Voo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    private static final String ARQUIVO_PASSAGEIROS = "passageiros.txt";
    private static final String ARQUIVO_TRIPULACAO = "tripulacao.txt";
    private static final String ARQUIVO_VOO = "voo.txt";

    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Seja bem vindo a Companhia Aérea Voo Seguro");
        System.out.println("Digite 1 para começar");
        int i = scan.nextInt();
        if(i == 1)
            menu();
    }

    public static void menu() {
        System.out.println("O que você deseja fazer?");
        System.out.println("1. Cadastrar Passageiro");
        System.out.println("2. Cadastrar Tripulante:");
        System.out.println("3. Cadastrar Voo:");
        System.out.println("4. Cadastrar Acentos:");
        System.out.println("5. Listar Passageiros:");
        System.out.println("6. Listar Tripulação:");
        System.out.println("7. Listar Voos:");
        System.out.println("8. Listar Acentos:");
        System.out.println("9. Fazer Reserva:");
        System.out.println("10. Baixa em Reserva:");
        System.out.println("11. Programa de Fidelidade:");
        System.out.println("12. Sair");



        int opcao = scan.nextInt();
        switch (opcao) {
            case 1: cadastrarPassageiro();break;
            case 2: cadastrarTripulacao();break;
            case 3: cadastrarVoo();break;
            case 4: funcionalidadeFutura();break;
            case 5: visualizarPassageiros();break;
            case 6: visualizarTripulacao();break;
            case 7: visualizarVoos();break;
            case 8: funcionalidadeFutura();break;
            case 9: funcionalidadeFutura();break;
            case 10: funcionalidadeFutura();break;
            case 11: funcionalidadeFutura();break;


        }

    }

    private static void funcionalidadeFutura() {
        System.out.println("Essa funcionalidade ainda não foi adicionada ao sistema, tente novamente mais tarde");
        menu();
    }


    private static void cadastrarPassageiro() {
        scan.nextLine();
        System.out.println("Digite o nome do Passageiro");
        String nome = scan.nextLine();
        System.out.println("Digite o endereço do Passageiro");
        String endereco = scan.nextLine();
        System.out.println("Digite o telefone do Passageiro");
        String telefone = scan.nextLine();

        int id = obterProximoId(ARQUIVO_PASSAGEIROS);
        Passageiro passageiro = new Passageiro(id, nome, endereco, telefone);

        try (FileWriter writer = new FileWriter(ARQUIVO_PASSAGEIROS, true)) {
            writer.write(passageiro.getId() + "," + passageiro.getNome() + "," + passageiro.getEndereco() + "," + passageiro.getTelefone() + "\n");
            System.out.println("Passageiro cadastrado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o passageiro no arquivo: " + e.getMessage());
        }

        System.out.println("Digite 1 para voltar e 2 para sair");
        int i = scan.nextInt();
        if (i == 1)
            menu();
    }

    private static void visualizarPassageiros() {

        List<Passageiro> passageiros = lerArquivoPassageiros();

        if (passageiros.isEmpty()) {
            System.out.println("Nenhum passageiro encontrado.");
        } else {
            System.out.println("Passageiros cadastrados:");
            for (Passageiro p : passageiros) {
                System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Endereço: " + p.getEndereco() + ", telefone: " + p.getTelefone());
            }
        }

        System.out.println("Digite 1 para voltar e 2 para sair");
        int i = scan.nextInt();
        if(i == 1)
            menu();
    }

    private static List<Passageiro> lerArquivoPassageiros() {
        List<Passageiro> passageiros = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_PASSAGEIROS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(","); // Separar ID e nome
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String endereco = dados[2];
                String telefone = dados[3];
                passageiros.add(new Passageiro(id, nome, endereco, telefone));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum passageiro cadastrado ainda.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return passageiros;


    }


    private static void cadastrarTripulacao() {
        scan.nextLine();
        System.out.println("Digite o nome do tripulante:");
        String nome = scan.nextLine();
        System.out.println("Digite o telefone do tripulante");
        String telefone = scan.nextLine();
        System.out.println("Selecione um cargo para ele");
        System.out.println("1. Piloto");
        System.out.println("2. Copiloto");
        System.out.println("3. Comissário de Bordo");
        System.out.print("Digite o número correspondente ao cargo: ");
        int escolha = scan.nextInt();
        String cargo = switch (escolha) {
            case 1 -> "Piloto";
            case 2 -> "Copiloto";
            case 3 -> "Comissário de Bordo";
            default -> throw new IllegalStateException("Não existe cargo " + escolha);
        };

        int id = obterProximoId(ARQUIVO_TRIPULACAO);
        Tripulacao tripulante = new Tripulacao(id, nome, telefone, cargo);

        try (FileWriter writer = new FileWriter(ARQUIVO_TRIPULACAO, true)) {
            writer.write(tripulante.getId() + "," + tripulante.getNome() + "," + tripulante.getTelefone() + "," + tripulante.getCargo() + "\n");
            System.out.println("Tripulante cadastrado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o tripulante no arquivo: " + e.getMessage());
        }

        System.out.println("Digite 1 para voltar e 2 para sair");
        int i = scan.nextInt();
        if (i == 1)
            menu();
    }



    private static void visualizarTripulacao() {
        

        List<Tripulacao> tripulacao = lerArquivoTripulacao();

        if (tripulacao.isEmpty()) {
            System.out.println("Nenhum Tripulante encontrado.");
        } else {
            System.out.println("Tripulantes cadastrados:");
            for (Tripulacao p : tripulacao) {
                System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Telefone: " + p.getTelefone() + ", Cargo: " + p.getCargo());
            }
        }

        System.out.println("Digite 1 para voltar e 2 para sair");
        int i = scan.nextInt();
        if(i == 1)
            menu();

    }

    private static List<Tripulacao> lerArquivoTripulacao() {

        List<Tripulacao> tripulacaos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_TRIPULACAO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(","); // Separar ID e nome
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String telefone = dados[2];
                String cargo = dados[3];


                tripulacaos.add(new Tripulacao(id, nome, telefone, cargo));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum Tripulante cadastrado ainda.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return tripulacaos;

    }



    private static void cadastrarVoo() {
        scan.nextLine();
        System.out.println("Digite a data do voo (formato: yyyy-MM-dd):");
        String dataInput = scan.nextLine();
        LocalDate data = LocalDate.parse(dataInput);

        System.out.println("Digite a hora do voo (formato: HH:mm):");
        String horaInput = scan.nextLine();
        LocalTime hora = LocalTime.parse(horaInput);

        System.out.println("Digite a origem do voo:");
        String origem = scan.nextLine();

        System.out.println("Digite o destino do voo:");
        String destino = scan.nextLine();

        System.out.println("Digite o código do avião:");
        int codigoAviao = scan.nextInt();

        System.out.println("Digite o código do piloto:");
        int codigoPiloto = scan.nextInt();

        System.out.println("Digite o código do copiloto:");
        int codigoCopiloto = scan.nextInt();

        System.out.println("Digite o código do comissário:");
        int codigoComissario = scan.nextInt();

        System.out.println("Digite a tarifa do voo:");
        double tarifa = scan.nextDouble();

        List<Tripulacao> tripulacao = lerArquivoTripulacao();
        boolean pilotoValido = tripulacao.stream().anyMatch(t -> t.getId() == codigoPiloto && t.getCargo().equalsIgnoreCase("Piloto"));
        boolean copilotoValido = tripulacao.stream().anyMatch(t -> t.getId() == codigoCopiloto && t.getCargo().equalsIgnoreCase("Copiloto"));

        String status = (pilotoValido && copilotoValido) ? "ativo" : "inativo";

        int codigoVoo = obterProximoId(ARQUIVO_VOO);
        Voo voo = new Voo(codigoVoo, data, hora, origem, destino, codigoAviao, codigoPiloto, codigoCopiloto, codigoComissario, status, tarifa);

        try (FileWriter writer = new FileWriter(ARQUIVO_VOO, true)) {
            writer.write(voo.getCodigoVoo() + "," + voo.getData() + "," + voo.getHora() + "," + voo.getOrigem() + "," +
                    voo.getDestino() + "," + voo.getCodigoAviao() + "," + voo.getCodigoPiloto() + "," +
                    voo.getCodigoCopiloto() + "," + voo.getCodigoComissario() + "," + voo.getStatus() + "," +
                    voo.getTarifa() + "\n");
            System.out.println("Voo cadastrado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o voo no arquivo: " + e.getMessage());
        }

        System.out.println("Digite 1 para voltar e 2 para sair");
        int i = scan.nextInt();
        if (i == 1)
            menu();
    }

    private static void visualizarVoos() {
        List<Voo> voos = lerArquivoVoos();
        if (voos.isEmpty()) {
            System.out.println("Nenhum voo encontrado.");
        } else {
            System.out.println("Voos cadastrados:");
            for (Voo v : voos) {
                System.out.println("Código do Voo: " + v.getCodigoVoo() +
                        ", Data: " + v.getData() +
                        ", Hora: " + v.getHora() +
                        ", Origem: " + v.getOrigem() +
                        ", Destino: " + v.getDestino() +
                        ", Código do Avião: " + v.getCodigoAviao() +
                        ", Código do Piloto: " + v.getCodigoPiloto() +
                        ", Código do Copiloto: " + v.getCodigoCopiloto() +
                        ", Código do Comissário: " + v.getCodigoComissario() +
                        ", Status: " + v.getStatus() +
                        ", Tarifa: " + v.getTarifa());
            }
        }

        System.out.println("Digite 1 para voltar e 2 para sair");
        int i = scan.nextInt();
        if (i == 1)
            menu();
    }

    private static List<Voo> lerArquivoVoos() {
        List<Voo> voos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_VOO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                int codigoVoo = Integer.parseInt(dados[0]);
                LocalDate data = LocalDate.parse(dados[1]);
                LocalTime hora = LocalTime.parse(dados[2]);
                String origem = dados[3];
                String destino = dados[4];
                int codigoAviao = Integer.parseInt(dados[5]);
                int codigoPiloto = Integer.parseInt(dados[6]);
                int codigoCopiloto = Integer.parseInt(dados[7]);
                int codigoComissario = Integer.parseInt(dados[8]);
                String status = dados[9];
                double tarifa = Double.parseDouble(dados[10]);

                voos.add(new Voo(codigoVoo, data, hora, origem, destino, codigoAviao, codigoPiloto, codigoCopiloto, codigoComissario, status, tarifa));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum voo cadastrado ainda.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return voos;
    }

    private static int obterProximoId(String arquivo) {
        int maiorId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                if (id > maiorId) {
                    maiorId = id;
                }
            }
        } catch (FileNotFoundException e) {
            // Arquivo ainda não existe, então o próximo ID será 1
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return maiorId + 1;
    }
}