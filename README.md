## **🏦 Conta Bancária - Aplicação Console (Java)**

Bem-vindo ao repositório **conta_bancaria**!  
Projeto simples em Java que simula um menu de operações bancárias via terminal (console), ideal para estudos de programação orientada a objetos, manipulação de entrada/saída e uso de cores ANSI no terminal.

---

## **✨ Sobre o Projeto**

Esta aplicação é um protótipo de sistema bancário voltado para aprendizado.  
Ela apresenta um menu interativo com opções para criar, listar, consultar, atualizar e remover contas, além de operações financeiras básicas (saque, depósito e transferência).  
O projeto também inclui utilitários para formatar texto com cores no terminal, tornando a interface mais amigável durante a execução.

---

## **🎯 Conteúdo do Repositório**

* **`src/conta_bancaria/Menu.java`**  
  Classe principal com o menu interativo exibido no terminal; contém as opções do sistema (criadas como placeholders para implementação posterior) e a rotina de encerramento com informações do autor.

* **`src/conta_bancaria/util/Cores.java`**  
  Classe utilitária com constantes ANSI para cores, textos em negrito, underlined e cores de fundo — usada para colorir a saída no console.

* **`.classpath`** & **`.project`**  
  Arquivos de configuração do Eclipse (projeto Java) — facilitam a importação do projeto na IDE.

---

## **⚙️ Pré-requisitos**

* **Java JDK 17+** instalado e com a variável `JAVA_HOME` configurada.  
* (Opcional) **Eclipse**, **IntelliJ IDEA** ou **VS Code** com suporte Java para abrir/importar o projeto.

---

## **⚙️ Como Clonar e Executar Localmente**

### **Clonar o repositório**
```bash
git clone https://github.com/iagozandone/conta_bancaria.git
cd conta_bancaria
```

Executar via IDE (recomendado para iniciantes)

1. Abra sua IDE (Eclipse/IntelliJ/VS Code).

2. Importe o projeto como Existing Java Project (Eclipse) ou Import Project (IntelliJ).

3. Configure o JDK (se necessário).

4. Execute a classe conta_bancaria.Menu como Java Application.

## 📂 Estrutura do Projeto

```bash
conta_bancaria/
├── src/
│   └── conta_bancaria/
│       ├── Menu.java
│       └── util/
│           └── Cores.java
├── .classpath
└── .project
```

📝 Detalhes das Classes

Menu.java

- Exibe UI em texto com bordas e opções numeradas.

- Lê a opção do usuário via Scanner.

- Implementa switch com cases para: criar conta, listar contas, buscar por número, atualizar, excluir, saque, depósito, transferência e sair.

- Ao sair, exibe uma tela final com dados do desenvolvedor.

Cores.java

- Define constantes públicas static final String com códigos ANSI para cores, negrito, sublinhado e fundos — usadas para estilizar a saída do console.

📖 Boas práticas / Próximos passos sugeridos

- Implementar classes de domínio (ex.: Conta, Cliente) e um repositório simples (ex.: List<Conta>) para persistência em memória.

- Persistência: adicionar um mecanismo de salvamento (arquivo JSON/CSV) ou integrar com banco de dados.

- Validar entradas do usuário (tratamento de InputMismatchException e proteção contra opções inválidas).

- Testes unitários (JUnit) para lógica de operações bancárias.

- Melhorar separação de responsabilidades (ex.: separar UI, serviço e persistência).

## 🤝 Como Contribuir

Contribuições são bem-vindas!

```bash
# 1. Fork do repositório no GitHub
# 2. Clone sua fork localmente
git clone <SUA_FORK_URL>
cd conta_bancaria

# 3. Crie uma branch para sua feature/ajuste
git checkout -b minha-feature

# 4. Faça suas alterações, depois:
git add .
git commit -m "Minha melhoria: descrição curta"
git push origin minha-feature

# 5. Abra um Pull Request no repositório original
```
## 📜 Licença

Este projeto está disponível para uso educacional e pessoal. Recomenda-se adicionar uma licença (ex.: MIT) se desejar permissões explícitas de reutilização e distribuição.

## 📞 Contato

Desenvolvido por Iago Zandone.

* [GitHub](https://github.com/iagozandone)
* [LinkedIn](https://www.linkedin.com/in/iagozandone)
* [Portfólio Pessoal](https://iagozandone.github.io/portfolio_fundweb/)
