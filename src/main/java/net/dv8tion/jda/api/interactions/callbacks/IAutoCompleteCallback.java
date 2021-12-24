/*
 * Copyright 2015 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dv8tion.jda.api.interactions.callbacks;

import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.requests.restaction.interactions.ChoiceAction;
import net.dv8tion.jda.internal.utils.Checks;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public interface IAutoCompleteCallback extends Interaction
{
    @Nonnull
    @CheckReturnValue
    ChoiceAction replyChoices(@Nonnull Collection<Command.Choice> choices);

    @Nonnull
    @CheckReturnValue
    default ChoiceAction replyChoices(@Nonnull Command.Choice... choices)
    {
        Checks.noneNull(choices, "Choice");
        return replyChoices(Arrays.asList(choices));
    }

    @Nonnull
    @CheckReturnValue
    default ChoiceAction replyChoice(@Nonnull String name, @Nonnull String value)
    {
        return replyChoices(new Command.Choice(name, value));
    }

    @Nonnull
    @CheckReturnValue
    default ChoiceAction replyChoice(@Nonnull String name, long value)
    {
        return replyChoices(new Command.Choice(name, value));
    }

    @Nonnull
    @CheckReturnValue
    default ChoiceAction replyChoice(@Nonnull String name, double value)
    {
        return replyChoices(new Command.Choice(name, value));
    }

    @Nonnull
    @CheckReturnValue
    default ChoiceAction replyChoiceStrings(@Nonnull String... choices)
    {
        return replyChoices(Arrays.stream(choices)
                .map(it -> new Command.Choice(it, it))
                .collect(Collectors.toList()));
    }

    @Nonnull
    @CheckReturnValue
    default ChoiceAction replyChoiceStrings(@Nonnull Collection<String> choices)
    {
        return replyChoices(choices.stream()
                .map(it -> new Command.Choice(it, it))
                .collect(Collectors.toList()));
    }

    @Nonnull
    @CheckReturnValue
    default ChoiceAction replyChoiceLongs(@Nonnull long... choices)
    {
        return replyChoices(Arrays.stream(choices)
                .mapToObj(it -> new Command.Choice(String.valueOf(it), it))
                .collect(Collectors.toList()));
    }

    @Nonnull
    @CheckReturnValue
    default ChoiceAction replyChoiceLongs(@Nonnull Collection<Long> choices)
    {
        return replyChoices(choices.stream()
                .map(it -> new Command.Choice(String.valueOf(it), it))
                .collect(Collectors.toList()));
    }

    @Nonnull
    @CheckReturnValue
    default ChoiceAction replyChoiceDoubles(@Nonnull double... choices)
    {
        return replyChoices(Arrays.stream(choices)
                .mapToObj(it -> new Command.Choice(String.valueOf(it), it))
                .collect(Collectors.toList()));
    }

    @Nonnull
    @CheckReturnValue
    default ChoiceAction replyChoiceDoubles(@Nonnull Collection<Double> choices)
    {
        return replyChoices(choices.stream()
                .map(it -> new Command.Choice(String.valueOf(it), it))
                .collect(Collectors.toList()));
    }
}
