# Plano de Implementação: Configuração do Ícone Oficial do App

Este plano visa substituir o ícone padrão do Android pelo ícone personalizado do **Clinique+**, utilizando a imagem do médico (emoji) fornecida pelo usuário, garantindo uma identidade visual consistente desde a tela de início do celular.

## User Review Required

> [!IMPORTANT]
> Atualmente, o seu arquivo `AndroidManifest.xml` não possui nenhuma configuração de ícone, o que faz o sistema Android exibir o robô verde padrão. Vamos ativar essa configuração agora.

## Proposed Changes

### [Recursos de Imagem]

#### [NEW] [ic_launcher_background.xml](file:///C:/Users/jankledson59266826/AndroidStudioProjects/App-de-Agendamento---/SistemaAgendamentoAndroid_Java/app/src/main/res/drawable/ic_launcher_background.xml)
- Definir um fundo branco limpo para o ícone adaptativo.

#### [NEW] [ic_launcher_foreground.xml](file:///C:/Users/jankledson59266826/AndroidStudioProjects/App-de-Agendamento---/SistemaAgendamentoAndroid_Java/app/src/main/res/drawable/ic_launcher_foreground.xml)
- Um arquivo XML que encapsula a imagem `ic_doctor_profile` para centralizá-la corretamente no ícone.

---

### [Configuração do Ícone (Mipmap)]

#### [NEW] [ic_launcher.xml](file:///C:/Users/jankledson59266826/AndroidStudioProjects/App-de-Agendamento---/SistemaAgendamentoAndroid_Java/app/src/main/res/mipmap-anydpi-v26/ic_launcher.xml)
- Definir o ícone adaptativo (Foreground + Background) para versões modernas do Android.

#### [NEW] [ic_launcher_round.xml](file:///C:/Users/jankledson59266826/AndroidStudioProjects/App-de-Agendamento---/SistemaAgendamentoAndroid_Java/app/src/main/res/mipmap-anydpi-v26/ic_launcher_round.xml)
- Definir a versão arredondada do ícone.

---

### [Manifesto]

#### [MODIFY] [AndroidManifest.xml](file:///C:/Users/jankledson59266826/AndroidStudioProjects/App-de-Agendamento---/SistemaAgendamentoAndroid_Java/app/src/main/AndroidManifest.xml)
- Adicionar os atributos `android:icon="@mipmap/ic_launcher"` e `android:roundIcon="@mipmap/ic_launcher_round"` na tag `<application>`.

## Verification Plan

### Manual Verification
1. Compilar o app e instalar no emulador.
2. Sair do app e olhar a lista de aplicativos instalados no Android.
3. Verificar se o ícone do robô foi substituído pelo ícone do médico (emoji) com fundo branco.
4. Garantir que o ícone aparece corretamente tanto no formato quadrado (com cantos arredondados) quanto no formato totalmente circular.
