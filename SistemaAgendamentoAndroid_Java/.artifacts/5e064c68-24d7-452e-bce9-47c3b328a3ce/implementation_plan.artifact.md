# Plano de Implementação: Carregamento Integrado no Botão de Login

Este plano visa refinar o feedback visual de carregamento na tela de login, integrando o indicador de progresso diretamente dentro do botão azul, mantendo a consistência visual e evitando a obstrução de outros elementos.

## Proposed Changes

### [Layouts]

#### [MODIFY] [activity_login.xml](file:///C:/Users/jankledson59266826/AndroidStudioProjects/App-de-Agendamento---/SistemaAgendamentoAndroid_Java/app/src/main/res/layout/activity_login.xml)
- Envolver o `MaterialButton` (btnLogin) e o `ProgressBar` em um `RelativeLayout` ou `FrameLayout`.
- Reposicionar o `ProgressBar` para que ele apareça centralizado à direita do texto do botão.
- Alterar a cor do `ProgressBar` para branco (`android:indeterminateTint="@color/white"`) para garantir contraste sobre o fundo azul.
- Ajustar o tamanho do `ProgressBar` para que ele caiba dentro da altura do botão sem deformá-lo.

---

### [Lógica de UI]

#### [MODIFY] [LoginActivity.java](file:///C:/Users/jankledson59266826/AndroidStudioProjects/App-de-Agendamento---/SistemaAgendamentoAndroid_Java/app/src/main/java/com/example/agendamento/LoginActivity.java)
- Manter o botão com sua cor azul original durante o carregamento.
- Para evitar que o botão fique "branco" (estado desabilitado padrão), utilizaremos uma lógica de bloqueio de cliques sem necessariamente desabilitar o componente visual, ou ajustaremos o `backgroundTint` para persistir no azul.
- Controlar a visibilidade do novo `ProgressBar` integrado.

## Verification Plan

### Manual Verification
1. Abrir a tela de login.
2. Clicar em "ACESSAR SISTEMA".
3. Verificar se o círculo de carregamento aparece **branco** e **ao lado** do texto, dentro do botão azul.
4. Confirmar que o botão **não muda de cor** (não fica cinza ou branco) durante o processo.
5. Verificar se cliques extras durante o carregamento são ignorados.
