//CRUD

object UserTable {

    var userId = mutableListOf(0,1)
    var userName = mutableListOf("Eder", "Sara")
    var userSurname = mutableListOf("Oliveira", "Rocha")

}

fun main() {

    mainMenu()

}

fun mainMenu(){

    println("1 - Create")
    println("2 - Read")
    println("3 - Update")
    println("4 - Delete")
    print("Escolha uma opção: ")
    var input: Int? = readlnOrNull()?.toInt()

    when (input) {

        1 -> {

            create()

        }

        2 -> {

            read()

        }
        3 -> {

            update()

        }

        4 -> {

            delete()

        }

    }

}

fun create() {

    print("Digite o nome do usuário:")
    val receiveUserName = readlnOrNull()
    print("Digite o sobrenome do usuário:")
    val receiveUserSurname = readlnOrNull()

    val newUserId = UserTable.userId.size

    UserTable.userId.add(newUserId)
    if (receiveUserName != null) {
        UserTable.userName.add(newUserId, receiveUserName)
    }
    if (receiveUserSurname != null) {
        UserTable.userSurname.add(newUserId, receiveUserSurname)
    }

    println("Usuário: ${UserTable.userName[newUserId]} ${UserTable.userSurname[newUserId]}  com o ID: $newUserId foi criado com sucesso!")

    read()
    readlnOrNull()
    mainMenu()

}


fun read() {

    for(id in UserTable.userId){
        println("| $id | ${UserTable.userName[id]} ${UserTable.userSurname[id]} ")
    }

    readlnOrNull()
    mainMenu()

}

fun update() {

    print("Digite o Id do usuário que será deletado: ")
    val updateUserId: Int? = readlnOrNull()?.toIntOrNull()
    print("Digite o novo nome do usuário: ")
    val newUserName = readlnOrNull()
    print("Digite o novo sobrenome do usuário: ")
    val newUserSurname = readlnOrNull()

    read()

    val oldUSerName = UserTable.userName[updateUserId!!]
    val oldUserSurname = UserTable.userSurname[updateUserId]

    newUserName!!.also { UserTable.userName[updateUserId] = it }
    newUserSurname!!.also { UserTable.userSurname[updateUserId] = it }

    read()
    readlnOrNull()
    mainMenu()

}

fun delete() {

    print("Digite o Id do usuário que será deletado:")
    val deleteUserId: Int? = readlnOrNull()?.toIntOrNull()

    if (deleteUserId != null) {

        val userDeleted = UserTable.userName[deleteUserId]
        val userIdDeleted = UserTable.userId[deleteUserId]

        UserTable.userId.removeAt(deleteUserId)
        UserTable.userName.removeAt(deleteUserId)
        UserTable.userSurname.removeAt(deleteUserId)

        println("Usuário: $userDeleted com o ID: $userIdDeleted foi deletado com sucesso")

        read()
        readlnOrNull()
        mainMenu()
    }
}
