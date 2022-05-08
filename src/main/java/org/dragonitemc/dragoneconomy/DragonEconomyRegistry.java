package org.dragonitemc.dragoneconomy;

import com.ericlam.mc.eld.registrations.CommandRegistry;
import com.ericlam.mc.eld.registrations.ComponentsRegistry;
import com.ericlam.mc.eld.registrations.ListenerRegistry;
import org.dragonitemc.dragoneconomy.command.dragems.*;
import org.dragonitemc.dragoneconomy.command.wrld.WrldCommand;
import org.dragonitemc.dragoneconomy.command.wrld.WrldDepositCommand;
import org.dragonitemc.dragoneconomy.command.wrld.WrldTransferCommand;
import org.dragonitemc.dragoneconomy.command.wrld.WrldWithdrawCommand;
import org.dragonitemc.dragoneconomy.manager.NFTokenManager;

import java.util.List;

public class DragonEconomyRegistry implements ComponentsRegistry {
    @Override
    public void registerCommand(CommandRegistry registry) {

        registry.command(DragemsCommand.class, sub -> {

            sub.command(DragemsBalanceCommand.class);

            sub.command(DragemsTransferCommand.class);

            sub.command(DragemsDepositCommand.class);

            sub.command(DragemsWithdrawCommand.class);

        });

        registry.command(WrldCommand.class, sub -> {

            sub.command(WrldDepositCommand.class);

            sub.command(WrldWithdrawCommand.class);

            sub.command(WrldTransferCommand.class);

        });

    }

    @Override
    public void registerListeners(ListenerRegistry registry) {
        registry.listeners(List.of(NFTokenManager.class));
    }
}
