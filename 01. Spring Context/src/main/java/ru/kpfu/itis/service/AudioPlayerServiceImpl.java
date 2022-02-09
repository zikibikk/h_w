package ru.kpfu.itis.service;

import ru.kpfu.itis.players.Player;
import ru.kpfu.itis.speaker.Speaker;

public class AudioPlayerServiceImpl implements AudioPlayerService {

    private Player player;
    private Speaker speaker;

    public AudioPlayerServiceImpl(Player player, Speaker speaker) {
        this.player = player;
        this.speaker = speaker;
    }

    @Override
    public void play() {
        player.playAudio("Скриптонит");
        speaker.out();
    }
}
