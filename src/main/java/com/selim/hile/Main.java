package com.selim.hile;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.C02PacketUseEntity;
import java.awt.Toolkit;

public class Main {
    private static Minecraft mc = Minecraft.getMinecraft();
    public static double range = 4.2; // Vuruş mesafesi (Blok)

    // Bu fonksiyonu her oyun tick'inde (güncellemesinde) çağıracağız
    public static void onUpdate() {
        // Dünyadaki tüm varlıkları tara
        for (Object obj : mc.theWorld.loadedEntityList) {
            if (obj instanceof EntityPlayer) {
                EntityPlayer target = (EntityPlayer) obj;

                // Kendimize vurmayalım ve mesafe kontrolü yapalım
                if (target != mc.thePlayer && mc.thePlayer.getDistanceToEntity(target) <= range) {
                    if (target.isEntityAlive()) {
                        
                        // 1. Sinyal ver (Bip sesi)
                        Toolkit.getDefaultToolkit().beep();

                        // 2. Vuruş Paketini Sunucuya Gönder
                        mc.thePlayer.sendQueue.addToSendQueue(
                            new C02PacketUseEntity(target, C02PacketUseEntity.Action.ATTACK)
                        );
                        
                        // 3. El sallama animasyonu (Görsel olarak vuruyormuş gibi durur)
                        mc.thePlayer.swingItem();
                        
                        // Her tick başına 1 kişiye vur (Ban riskini azaltmak için)
                        break; 
                    }
                }
            }
        }
    }
}
