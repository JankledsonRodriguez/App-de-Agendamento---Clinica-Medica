# Plano de Implementação: Correção de Segurança e Limpeza do Git

Este plano visa resolver o bloqueio de "Push Protection" do GitHub, que ocorreu devido à detecção de senhas no histórico de commits e à presença de arquivos temporários de build no repositório.

## User Review Required

> [!CAUTION]
> O GitHub bloqueou o seu envio porque detectou uma **senha real** (provavelmente do serviço Aiven) no arquivo `DatabaseConfig.java`. Mesmo que você mude o arquivo agora, a senha continua salva no "passado" do seu Git (nos commits anteriores).

> [!IMPORTANT]
> Além da senha, pastas como `build/`, `.gradle/` e `.idea/` estão sendo enviadas para o GitHub. Isso é uma prática incorreta que deixa o repositório pesado e causa erros de compilação para outras pessoas.

## Proposed Changes

### [Git & Configuração]

#### [NEW] [.gitignore](file:///C:/Users/jankledson59266826/AndroidStudioProjects/App-de-Agendamento---/SistemaAgendamentoAndroid_Java/.gitignore)
- Criar o arquivo de ignorar padrão para Android/Java.
- Impedir que as pastas `build/`, `.gradle/`, `.idea/` e arquivos como `local.properties` sejam rastreados.

#### [MODIFY] [DatabaseConfig.java](file:///C:/Users/jankledson59266826/AndroidStudioProjects/App-de-Agendamento---/SistemaAgendamentoAndroid_Java/app/src/main/java/com/example/agendamento/database/DatabaseConfig.java)
- Garantir que não existam senhas reais no código.
- Recomendação: O usuário deve inserir a senha manualmente no código localmente, mas nunca enviá-la para o GitHub.

### [Limpeza de Rastro (Ações Manuais Necessárias)]

Para resolver o erro de commit bloqueado, você precisará executar alguns comandos no terminal do Android Studio, pois eu não posso reescrever o seu histórico de commits local:

1. **Remover arquivos indesejados do cache do Git:**
   `git rm -r --cached .`
   `git add .`
   `git commit -m "Limpeza de arquivos de build e adicao de .gitignore"`

2. **Remover o segredo do histórico (Opção Simples):**
   Como o push foi rejeitado, a forma mais fácil é fazer um "Soft Reset" para antes do commit problemático, remover a senha, e fazer um novo commit limpo.

## Verification Plan

### Manual Verification
1. Criar o `.gitignore`.
2. Verificar se a pasta `build/` parou de aparecer como "verde" ou "rastreada" no Git.
3. Tentar realizar um novo commit e push.
