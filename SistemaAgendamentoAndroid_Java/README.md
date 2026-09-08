# 🩺 Clinique+ | Sistema de Gestão Clínica Inteligente

O **Clinique+** é uma plataforma de gestão médica robusta desenvolvida em **Java nativo para Android**. Projetado para oferecer uma experiência de nível profissional, o sistema integra uma interface sofisticada baseada no **Material Design 3** com um backend relacional **MySQL**, permitindo o controle total do ciclo de atendimento em clínicas e consultórios.

---

## 🏗️ 1. Arquitetura e Estrutura Técnica

O projeto segue o padrão de arquitetura organizada para garantir escalabilidade e fácil manutenção:

-   **`com.example.agendamento.ui`**: Camada de interface, contendo Fragments e Activities que gerenciam a interação com o usuário.
-   **`com.example.agendamento.model`**: Classes de dados (POJOs) como `Paciente`, `Consulta` e `Medico`.
-   **`com.example.agendamento.repository`**: Centralização da lógica de negócios e persistência. É a ponte entre a UI e o banco de dados.
-   **`com.example.agendamento.database`**: Configurações de rede, gerenciamento de drivers JDBC e conexões com o MySQL.
-   **Fluxo de Dados**: A aplicação utiliza `ExecutorService` para processar consultas SQL em threads secundárias, garantindo que a interface permaneça fluida e sem travamentos (ANR).

---

## 📱 2. Tour Detalhado pelas Telas

### 🔐 Acesso e Segurança
-   **Splash Screen:** Tela de abertura com identidade visual azul vibrante, preparando o ambiente de prontuários.
-   **Login Inteligente:** Autenticação segura com feedback de carregamento embutido no próprio botão e prevenção de cliques múltiplos.
-   **Auto-cadastro de Médicos:** Fluxo para novos profissionais criarem seus perfis, vinculando dados de acesso e registro profissional (CRM).
-   **Recuperação de Senha:** Sistema de segurança de duas etapas, exigindo um **código de verificação de 6 dígitos** enviado ao e-mail institucional antes de permitir a redefinição da senha.

### 📊 Painel de Controle (Início)
O centro de comando do médico, apresentando:
-   **Dashboard Operacional:** Indicadores automáticos de consultas do dia, próximos atendimentos e triagem por status (Confirmadas, Pendentes, Canceladas).
-   **Navegação Drill-down:** Clicar em qualquer indicador estatístico abre a agenda já filtrada para aquela situação específica.
-   **Seletor de Tema:** Localizado estrategicamente no canto inferior, permite alternar entre **Modo Claro e Escuro** instantaneamente.

### 📅 Gestão de Atendimentos (Agenda & Consultas)
-   **Agenda 360°:** Visualização flexível em escalas **Diária, Semanal e Mensal** com calendário interativo.
-   **Listagem em Grade:** Layout moderno de duas colunas que facilita a leitura rápida de nomes e horários.
-   **Controle de Status Operacional:** Gestão do fluxo do paciente em tempo real:
    -   *Agendado* ➡️ *Confirmado* (Check-in) ➡️ *Em Atendimento* ➡️ *Atendido* ou *Faltou*.
-   **Reagendamento Dinâmico:** Alteração rápida de datas e horários através de seletores visuais nativos (DatePicker e TimePicker).

### 📑 Módulo de Pacientes e Prontuário
-   **Cadastro Abrangente:** Coleta de CPF, data de nascimento, contatos e endereço completo.
-   **Prontuário Digital:** Ao selecionar um paciente, o sistema abre sua ficha completa, exibindo dados pessoais e um **Histórico Clínico cronológico** de todas as passagens pela clínica.

### ⚕️ Especialidades e Corpo Clínico
-   **Vitrine Dinâmica:** A lista de especialidades se auto-ajusta. Se um médico de uma nova área é cadastrado, o card da especialidade surge automaticamente na vitrine.
-   **Filtros de Especialista:** Permite filtrar toda a rede de médicos por sua área de atuação com um clique.

---

## ⚙️ 3. Configuração e Implementação

### 💾 Banco de Dados MySQL
1.  Utilize um servidor MySQL (XAMPP local ou Cloud).
2.  Importe o script oficial localizado em `/sql/agendamento.sql`.
3.  O script criará as tabelas `usuarios`, `pacientes`, `medicos`, `consultas` e `especialidades` com todos os relacionamentos necessários.

### 🌐 Conexão de Rede
Configure o endereço do servidor no arquivo:
`app/src/main/java/com/example/agendamento/database/DatabaseConfig.java`
-   **Local/Emulador:** `10.0.2.2`
-   **Rede Local/Físico:** Endereço IP do computador servidor.

### 🔑 Credenciais de Teste
-   **Admin:** `admin@clinique.com` | **Senha:** `123456`

---

## 🌗 4. Funcionalidades de Experiência (UX)
-   **Suporte a Mouse:** Configurado para rolagem suave via *scroll wheel*, ideal para uso em tablets com periféricos ou emulação.
-   **Persistência de Tema:** O aplicativo memoriza o modo visual escolhido pelo usuário através de `SharedPreferences`.
-   **Layout Adaptativo:** Cards e textos utilizam cores semânticas que garantem 100% de legibilidade tanto no fundo branco quanto no cinza chumbo do modo noturno.

---

## 🛡️ 5. Práticas de Segurança
-   **Git Protection:** Arquivo `.gitignore` configurado para não subir pastas de `build/`, `.gradle/` ou segredos de configuração local.
-   **Mascaramento de Dados:** As credenciais sensíveis são gerenciadas fora do histórico de commits do repositório público.

---
> [!NOTE]
> Este projeto demonstra a potência do desenvolvimento Android Nativo em Java unido a sistemas de banco de dados relacionais para soluções empresariais complexas.
