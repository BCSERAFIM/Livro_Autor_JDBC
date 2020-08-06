package aplicacao;

import java.util.List;
import java.util.Scanner;

import dao.AutorDao;
import dao.DaoFactory;
import dao.LivroAutorDao;
import entities.Autor;
import entities.LivroAutor;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		AutorDao autorDao = DaoFactory.creatAutorDao();
		LivroAutorDao livroAutorDao = DaoFactory.creatLivroAutorDao();

		while (true) {
			try {
				System.out.println();
				System.out.println();
				System.out.println("Escolha uma das opções e tecle <ENTER>: ");
				System.out.println("  1 - Incluir Autor");
				System.out.println("  2 - Incluir Livro");
				System.out.println("  3 - Listar Autores");
				System.out.println("  4 - Listar Livros");
				System.out.println("  5 - Listar Autores de um livro");
				System.out.println("  6 - Listar Livros de um autor");
				System.out.println("  7 - Sair");
				System.out.print("  : ");
				String opcao = sc.nextLine();
				System.out.println();
				System.out.print("Opção escolhida [" + opcao + "] \n");

				switch (opcao) {
				case "1":
					System.out.println("Digitar Nome do Autor");
					System.out.print("  Nome: ");
					String nome = sc.nextLine();
					Autor newAutor = new Autor(null, nome);
					autorDao.insert(newAutor);
					System.out.println("Inserted! New id = " + newAutor.getId());
					break;
				case "2":
					System.out.println("Digitar Nome do Livro");
					System.out.print("  Nome: ");
					String titulo = sc.nextLine();
					System.out.println("Vincular ao Autor");
					System.out.print("ID Autor: ");
					int autorId = sc.nextInt();
					sc.nextLine();
					Autor autor = new Autor(autorId, null);
					LivroAutor newLivroAutor = new LivroAutor(null, titulo, autor);
					livroAutorDao.insert(newLivroAutor);
					System.out.println("Inserted! New id = " + newLivroAutor.getId());
					break;
				case "3":
					List<Autor> listaAutor = autorDao.findAll();
					for (Autor aut : listaAutor) {
						System.out.println(aut);
					}
					break;
				case "4":
					List<LivroAutor> listaLivro = livroAutorDao.findAll();
					for (LivroAutor livro : listaLivro) {
						System.out.println(livro);
					}			
					break;
				case "5":
					System.out.println("Digitar Id do Livro");
					System.out.print("  ID Livro: ");
					int idLivro = sc.nextInt();
					sc.nextLine();
					LivroAutor livroAutor = livroAutorDao.findById(idLivro);
					System.out.println(livroAutor);
					
					break;
				case "6":
					System.out.println("Digitar Id Autor");
					System.out.print("  ID Autor: ");
					int id = sc.nextInt();
					sc.nextLine();
					Autor autor1 = new Autor(id, null);
					List<LivroAutor> listaLivroAutor = livroAutorDao.findByAutor(autor1);
					for (LivroAutor obj : listaLivroAutor) {
						System.out.println();
						System.out.println("ID = " + obj.getId() + " , " + obj.getTitulo());
					}
					break;
				
				case "7":
					System.out.println("Fim da operação!");
					break;
				default:
					System.out.println("Opção Invalida.");
					break;
				}
				if (opcao.equals("7")) {

					break;
				}
			} catch (Exception ex) {
				System.out.println(" Falha na operação. Mensagem =" + ex.getMessage());
				
			}
		}

		sc.close();
	}

}
