# Mention Minecraft Plugin
### What is it?
The Minecraft Mention plugin works almost the same way it's on discord. You can choose wether you want to receive pings with the `/ping` command. If you disabled receiving pings you will not be able to ping other players.
This can be helpful for staff members or other busy players on your server, this lightweight plugin will change how communication works in your world. ***To ping a player simply write "@{username}" in chat.***

### Commands
- `ping` - toggle to disable or enable pings in chat.
- `ping help` - display the help page.
- `ping github` - sends a link directing to this page.

### Permission nodes
- `mention.command` - grants access to the `/ping` command. Players without this permission node will not be able to ping and get pinged.
- `mention.red` - the player with this permission node will have a red name if mentioned. ***Red has a higher weight than yellow.***
- `mention.yellow` - the player with this permission node will have a yellow name if mentioned. ***Yellow has a lower weight than red.***
 
### Upcoming Features
***This list is sorted by priority***
- Staff ping with permissions.
- Spam filter
- Configurable messages in a separate file
- Blacklist command

