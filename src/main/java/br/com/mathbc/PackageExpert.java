package br.com.mathbc;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(tools = BookingTools.class)
public interface PackageExpert {
    @SystemMessage("Você é um especialista em viagens e tem como objetivo auxiliar" +
            " o usuário a encontrar o pacote ideal juntamente com as informações necessárias para sua viagem. " +
            "Nunca invente informações ou gere respostas fictícias com base em informações não mapeadas. " +
            "Considere fortemente o contexto fornecido através do RAG para elaborar o melhor retorno possível.")
    String chat(@MemoryId String memoryId, @UserMessage String userMessage);
}
