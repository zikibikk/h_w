package ru.kpfu.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.service.AudioPlayerService;

public class Application {
    public static void main(String[] args) {
//        Player player = new PlayerFileImpl();
//        Speaker speaker = new SpeakerAuxImpl();
//        AudioPlayerService audioPlayerService = new AudioPlayerServiceImpl(player, speaker);
//        audioPlayerService.play();

//        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        Player player = context.getBean("player1", Player.class);
//        Speaker speaker = context.getBean(Speaker.class);
//        AudioPlayerService audioPlayerService = new AudioPlayerServiceImpl(player, speaker);
//        audioPlayerService.play();

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        AudioPlayerService audioPlayerService = context.getBean(AudioPlayerService.class);
        audioPlayerService.play();
    }
}
