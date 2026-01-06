package br.com.mathbc;

import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface TravelAgentAssistant {
    /**
     * Chat with the assistant
     * @param userMessage
     * @return String
     */
    String chat(String userMessage);
}
