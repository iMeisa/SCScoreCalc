print("Welcome to Speed Cup Score Calculator")

matchNumber = int(input("\nMatch ##?\n> "))
teamBlue = input("\nWhat is the name of the blue team?\n> ")
teamRed = input("\nWhat is the name of the red team\n> ")
BOn = int(input("\nBest of how many?\n> "))
print(f"BO{BOn} = {BOn // 2 + 1} points to win")

input("\n\nWaiting for warmups to finish...")


order = int(input("\nWhich team won the roll?\n1. Blue 2. Red\n> "))

maps = ['DT1', 'DT2', 'DT3', 'DT4', 'DT5', 'DT6', 'DT7', 'DT8']
maps2 = ['DT9', 'DT10', 'DT11', 'DT12', 'DT13', 'NM1', 'NM2', 'TB']
mapIDs = ['124056', '715345', '1773874', '603965', '2036906', '207659', '263382', '507728']
mapIDs2 = ['2042978', '970516', '34162', '1236720', '152463', '2063785', '169841', '252238']

if order % 2 != 0:
    while True:
        redBan = input("\nTeam Red bans!\n\nWhat is Team Red's ban?\n> ")
        if redBan not in maps and redBan not in maps2:
            print("Pick a valid map")
            continue
        break
    while True:
        blueBan = input("\nTeam Blue bans!\n\nWhat is Team Blue's ban?\n> ")
        if blueBan not in maps and blueBan not in maps2:
            print("Pick a valid map")
            continue
        break
else:
    while True:
        blueBan = input("\nTeam Blue bans!\n\nWhat is Team Blue's ban?\n> ")
        if blueBan not in maps and blueBan not in maps2:
            print("Pick a valid map")
            continue
        break
    while True:
        redBan = input("\nTeam Red bans!\n\nWhat is Team Red's ban?\n> ")
        if redBan not in maps and redBan not in maps2:
            print("Pick a valid map")
            continue
        break


bluePoints = 0
redPoints = 0
playedMaps = []
isTied = False

while bluePoints < BOn // 2 + 1 and redPoints < BOn // 2 + 1:

    if order % 2 != 0:
        mapPick = input("\nTeam Blue's pick!\n> ")
    else:
        mapPick = input("\nTeam Red's pick!\n> ")
    while True:
        if mapPick in blueBan or mapPick in redBan:
            mapPick = input("Map banned\n> ")
        elif mapPick not in maps and mapPick not in maps2:
            mapPick = input("Pick a valid map\n> ")
        elif mapPick in playedMaps:
            mapPick = input("Map already played\n> ")
        elif mapPick in maps:
            print(f"!mp map {mapIDs[maps.index(mapPick)]}")
            break
        elif mapPick in maps2:
            print(f"!mp map {mapIDs2[maps2.index(mapPick)]}")
            break
    playedMaps.append(mapPick)
    order += 1

    input("\nWaiting for match to finish...")

    blueAcc = float(input("\nTeam Blue's accuracy\n> "))
    redAcc = float(input("\nTeam Red's accuracy\n> ")) * 5 / 4
    print(f"Red Acc: {redAcc:4}")

    if blueAcc > redAcc:
        bluePoints += 1
    else:
        redPoints += 1

    print(f"{teamBlue} {bluePoints} | {redPoints} {teamRed}")
    print("-------------------------------------------------")

    if bluePoints > redPoints:
        print(f"{teamBlue} wins!")
    elif bluePoints == BOn // 2 and redPoints == BOn // 2:
        print("\nTiebreaker time!")
        isTied = True
    else:
        print(f"{teamRed} wins!")

matchLink = input("\nMatch Link\n> ")

print(f"""__**Semifinals**__
**Match {matchNumber}:** {matchLink}

Results: {teamBlue} **{bluePoints} | {redPoints}** {teamRed}

**Bans:**
{teamBlue}: **{blueBan}**
{teamRed}: **{redBan}**""")


