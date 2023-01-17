package me.oyuncozucu.minigame.listener;

import me.oyuncozucu.minigame.GameState;
import me.oyuncozucu.minigame.Minigame;
import me.oyuncozucu.minigame.instance.Arena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class GameListener implements Listener {

    private Minigame minigame;

    public GameListener(Minigame minigame) {
        this.minigame = minigame;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        Arena arena = minigame.getArenaManager().getArena(e.getPlayer());


        if(arena != null && arena.getState().equals(GameState.LIVE)) {
            arena.getGame().addPoint(e.getPlayer());

        }

    }

}
