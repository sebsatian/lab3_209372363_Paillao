package TDAs;

import java.util.List;
import java.util.ArrayList;


public class System {
    /* Atributos */
    String name;
    int initialChatbotCodeLink;
    public List<Chatbot> systemChatbots;

    public List<User> systemUsers;
    int currentChatbot;
    int currentFlow;

    /* Constructores */
    public System(String name, int initialChatbotCodeLink, List<Chatbot> systemChatbots) {
        this.name = name;
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.systemChatbots = systemChatbots;
        this.systemUsers = new ArrayList<>();
        this.currentChatbot = initialChatbotCodeLink;
        this.currentFlow = -1;
    }

    /* Selectores*/
    public String getName() {
        return name;
    }
    public int getInitialChatbotCodeLink() {
        return initialChatbotCodeLink;
    }
    public List<Chatbot> getChatbots() {
        return systemChatbots;
    }

    /* Metodo publico para añadir un chatbot a la lista de chatbots del sistema */
    public void systemAddChatbot(Chatbot newChatbot){
        if (!isChatbotInSystem(newChatbot)){
            systemChatbots.add(newChatbot);
        }
    }

    /* Metodo privado para comprobar si un chatbot existe dentro del sistema */
    private boolean isChatbotInSystem(Chatbot newChatbot){
        for (Chatbot chatbot : systemChatbots){
            if (chatbot.getID() == newChatbot.getID()){
                return true;
            }
        }
    return false;
    }

    /* Metodo publico para añadir un usuario a la lista de usuarios del sistema */
    public void systemAddUser(User newUser){
        if(!isUserInSystem(newUser)){
            systemUsers.add(newUser);
        }
    }

    /* Metodo privado para comprobar si un usuario existe dentro del sistema */
    private boolean isUserInSystem(User newUser){
        for (User user : systemUsers){
            if ((user.getUsername()).equals(newUser.getUsername())){
                return true;
            }
        }
    return false;
    }

    /* Metodo publico para iniciar sesion a un usuario*/
    public void systemLogin(String username){
        for (User user : systemUsers){
            if (user.getUsername().equals(username) && user.getUserStatus().equals("notLogged")){
                user.setUserStatus("logged");
                break;
            }
        }
    }

    private boolean isAnyUserLogged(){
        for(User user : systemUsers){
            if (user.getUserStatus().equals("Logged")){
                return true;
            }
        }
        return false;
    }

    /* Metodo publico para cerrar la sesion del usuario que la tenga iniciada */
    public void systemLogout(){
        for(User user : systemUsers){
            if (isAnyUserLogged()){
                user.setUserStatus("notLogged");
                break;
            }
        }
    }
    public void systemTalk(String message ){
        if(isAnyUserLogged()){
            if (isNumber(message)){


            }
        }
    }

    /* Obtener opciones del flujo */



    /* Metodo para encontrar el flujo y el chatbot actuales */
    private Chatbot findChatbotByCode(int currentChatbot) {
        for (Chatbot chatbot : this.systemChatbots) {
            if (chatbot.getID() == currentChatbot) {
                return chatbot;
            }
        }
        return null; // Retorna null si no se encuentra el chatbot
    }



    private int findOption (String message) {
        for (Option option : currentFlow.get){

        }
    }

    /* Metodo para saber si la entrada del usuario es un numero o no */
    private boolean isNumber(String message){
        try {
            Integer.parseInt(message);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
