# ☁️ Nimbus - Aplicativo de Clima

Nimbus é um aplicativo de clima simples para Android, desenvolvido nativamente em Java. Ele permite ao utilizador pesquisar o clima atual de qualquer cidade e mantém um histórico das pesquisas recentes para consulta rápida.
</br></br>
Os dados de clima são consumidos em tempo real da API ``OpenWeather``.

## Screenshots

### Tela inicial
<img width="386" height="862" alt="Captura de tela 2025-10-26 175252" src="https://github.com/user-attachments/assets/5a52b660-5a87-4854-b12d-bbae4a4e5706" />

### Tela de pesquisa

<img width="385" height="862" alt="Captura de tela 2025-10-26 175025" src="https://github.com/user-attachments/assets/49dcf59e-d3fe-4202-b8c6-ce839fa43e13" />

### Tela de detalhes

<img width="389" height="861" alt="Captura de tela 2025-10-26 174904" src="https://github.com/user-attachments/assets/e8f34486-4536-4a33-ac5d-9dda6143b6c0" />

## ✨ Funcionalidades

- Clima Atual: Exibe a temperatura, descrição do clima (ex: "Céu Limpo"), e as temperaturas máxima e mínima da última cidade pesquisada.

- Pesquisa de Cidades: Uma tela de pesquisa dedicada para encontrar o clima de qualquer cidade do mundo.

- Persistência de Dados: Utiliza SharedPreferences para:

 Salvar e carregar a última cidade pesquisada, para que o utilizador veja informações relevantes ao abrir o app.

 Salvar e carregar a lista de histórico de pesquisas.

- Histórico de Pesquisas: Todas as pesquisas bem-sucedidas são adicionadas a um RecyclerView na tela principal.

- Tela de Detalhes: Ao clicar num item do histórico, o utilizador é levado a uma nova tela que exibe informações adicionais, como velocidade do vento, pressão atmosférica e humidade.

- UI Moderna: Interface limpa com fundos em gradiente.

## 🛠️ Tecnologias Utilizadas

- Java e Android SDK Nativo

- Retrofit2: Um cliente HTTP type-safe para fazer chamadas à API OpenWeather.

- Gson: Para converter os objetos JSON da API em objetos Java (POJOs).

- SharedPreferences: Para armazenamento local simples (persistência da última cidade e histórico).

## 🚀 Como Executar

1. Clone o repositório: ``git clone [https://github.com/seu-usuario/nimbus.git](https://github.com/seu-usuario/nimbus.git)
``</br></br>
2. Abra no Android Studio</br>

* Selecione "Open an existing project".

* Navegue até à pasta do projeto clonado e selecione-a.</br></br>

3. Adicione a sua Chave da API (Obrigatório):
- Este projeto requer uma chave da API gratuita do site OpenWeather, acesse esse site e crie sua chave: ``openWeathermap.org/api``.

- Abra o ficheiro app/src/main/java/com/example/nimbus/activities/MainActivity.java.

- Encontre a constante API_KEY.

- Substitua "SUA_CHAVE_API_AQUI" pela sua chave pessoal: ``private static final String API_KEY = "SUA_CHAVE_API_AQUI";
``

