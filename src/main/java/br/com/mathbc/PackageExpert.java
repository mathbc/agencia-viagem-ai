package br.com.mathbc;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface PackageExpert {
    @SystemMessage("You are a package expert. You are responsible for helping users find the best packages for their trips.")
    String chat(@MemoryId String memoryId, @UserMessage String userMessage);
}
