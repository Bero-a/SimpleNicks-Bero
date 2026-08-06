package simplexity.simplenicks.tags;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.ParsingException;
import net.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.bukkit.entity.Player;

public final class NameTag {
    public static final String NAME = "name";

    public static final TagResolver RESOLVER = TagResolver.resolver(
            NameTag.NAME,
            NameTag::create
    );

    private NameTag() {
    }

    static Tag create(final ArgumentQueue args, final Context ctx) throws ParsingException {
        final String playerName = args.popOr("Player name is required").value();

        return Tag.styling(
                HoverEvent.showText(Component.text(playerName)),
                ClickEvent.suggestCommand("/w " + playerName + " ")
        );
    }


}


