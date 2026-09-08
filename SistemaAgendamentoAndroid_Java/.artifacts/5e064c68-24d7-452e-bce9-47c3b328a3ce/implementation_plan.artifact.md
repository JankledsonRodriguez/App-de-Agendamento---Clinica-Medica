# Plano de Implementação: Ajuste de Escala e Alinhamento do Ícone

Este plano visa corrigir o problema de preenchimento do ícone do aplicativo, garantindo que a logo da clínica ocupe o espaço correto e preencha melhor as bordas, mantendo a visibilidade dentro da zona de segurança do Android.

## Proposed Changes

### [Recursos Visuais]

#### [MODIFY] [ic_launcher_foreground.xml](file:///C:/Users/jankledson59266826/AndroidStudioProjects/App-de-Agendamento---/SistemaAgendamentoAndroid_Java/app/src/main/res/drawable/ic_launcher_foreground.xml)
- Aumentar o tamanho da logo de 72dp para **108dp** (tamanho total do canvas do ícone adaptativo).
- Isso permitirá que a logo preencha melhor os espaços laterais. O Android fará o corte automático das bordas conforme o formato do ícone do sistema (círculo ou quadrado).

---

### [Configuração do Ícone]

#### [MODIFY] [ic_launcher.xml](file:///C:/Users/jankledson59266826/AndroidStudioProjects/App-de-Agendamento---/SistemaAgendamentoAndroid_Java/app/src/main/res/mipmap-anydpi-v26/ic_launcher.xml)
- Corrigir a referência do `foreground` de `@mipmap/ic_launcher_foreground` para **`@drawable/ic_launcher_foreground`**. Isso garantirá que o sistema utilize a nossa configuração personalizada que centraliza e escala a logo.

#### [MODIFY] [ic_launcher_round.xml](file:///C:/Users/jankledson59266826/AndroidStudioProjects/App-de-Agendamento---/SistemaAgendamentoAndroid_Java/app/src/main/res/mipmap-anydpi-v26/ic_launcher_round.xml)
- Realizar a mesma correção de referência para o ícone arredondado.

## Verification Plan

### Manual Verification
1. Reinstalar o aplicativo.
2. Verificar na tela inicial se a logo agora preenche melhor o ícone e se o fundo azul está correto.
3. Confirmar que a logo não está "sobrando" (espaços vazios excessivos nas laterais) e está bem distribuída.
